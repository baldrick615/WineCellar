package com.trm.winecellar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

public class WineDAOImpl implements WineDao {
	
	private static String select = "SELECT id, NAME, vintage, varietal, notes, price, quantity, region ";
	
	private static String selectAllWines = select 
			+ "FROM wines ";
	
	private static String selectWinesByRegion = select 
			+ "FROM wines " 
			+ "WHERE region = ? ";
	
	private static String selectWinesById = select 
			+ "FROM wines "
			+ "WHERE id = ? ";
	
	private static String deleteWineById =  
			"DELETE FROM wines "
			+ "WHERE id = ? ";
	
	private static String updateWineById = 
			"UPDATE wines "
			+ "SET NAME = ?, "
			+ "vintage = ?, "
			+ "varietal = ?, "
			+ "region = ?, "
			+ "quantity = ?, "
			+ "price = ?, "
			+ "notes = ? "
		+ "WHERE id = ? ";
	
	private static String selectWinesByRangeOfVintage = 
			select
			+ "FROM wines "
			+ "WHERE vintage >= ? "
			+ "AND vintage <= ? ";
	
	private static String insertWine = 
			"INSERT INTO wines (NAME, vintage, varietal, region, quantity, price, notes) "
			+ "VALUES "
			+ "(?,?,?,?,?,?,?) ";
	
	private static String selectWinesByQuantity = 
			select
			+ "FROM wines "
			+ "WHERE quantity = ? ";
	
	
	private static String selectNewWineId = 
			"SELECT LAST_INSERT_ID() AS 'id' ";
					

	@Override
	public List<Wine> getWines() {
		List<Wine> myWines = new ArrayList<Wine>();
		ResultSet rs = null;
		Statement s = null;
		
		Connection conn = MariaDBUtil.getConnection();
		
		try {
			s = conn.createStatement();
			rs = s.executeQuery(selectAllWines);
			myWines = makeWine(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				s.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return myWines;
	}
	
	
	private List<Wine> makeWine(ResultSet rs) throws SQLException {
		List<Wine> myWines = new ArrayList<Wine>();
		while(rs.next()) {
			Wine wine = new Wine();
			wine.setId(rs.getInt("id"));
			wine.setName(rs.getString("name"));
			wine.setQuantity(rs.getInt("quantity"));
			wine.setVintage(rs.getInt("vintage"));
			String regionString = rs.getString("region");
			wine.setRegion(Region.convertStringToRegion(regionString));
			String varietalString = rs.getString("varietal");
			wine.setVarietal(Varietal.convertStringToVarietal(varietalString));
			wine.setPrice(rs.getBigDecimal("price"));
			wine.setNotes(rs.getString("notes"));
			
			myWines.add(wine);
		}
		return myWines;
	}

	@Override
	public List<Wine> getWinesByRegion(Region region) {
		List<Wine> myWines = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDBUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectWinesByRegion);
			ps.setString(1, region.toString());
			rs = ps.executeQuery();
			myWines = makeWine(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return myWines;
	}

	@Override
	public List<Wine> getWinesByVintage(Integer vintage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wine> getWinesById(Integer id) {
		List<Wine> myWines = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDBUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectWinesById);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			myWines = makeWine(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return myWines;
	}
	
	@Override
	public List<Wine> getWinesByQuantity(Integer quantity) {
		List<Wine> myWines = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDBUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectWinesByQuantity);
			ps.setInt(1, quantity);
			rs = ps.executeQuery();
			myWines = makeWine(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return myWines;
	}
	
	
	@Override
	public Wine createWine(Wine newWine) {
		PreparedStatement ps = null;
		Connection conn = MariaDBUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(insertWine);
			ps.setString(1, newWine.getName());
			ps.setInt(2, newWine.getVintage());
			ps.setString(3, newWine.getVarietal().toString());
			ps.setString(4, newWine.getRegion().toString());
			ps.setInt(5, newWine.getQuantity());
			ps.setBigDecimal(6, newWine.getPrice());
			ps.setString(7, newWine.getNotes());
			int rowCount = ps.executeUpdate();
			System.out.println("insert row count: " + rowCount);
			int newWineId = getNewWineId(conn);
			newWine.setId(newWineId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return newWine;
	}

	
	@Override
	public Wine deleteWine(Integer id) {
		List<Wine> wines = getWinesById(id);
		Wine wineToDelete = null;
		
		if (wines.size() > 0) {
			wineToDelete = wines.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDBUtil.getConnection();
			try {
				ps = conn.prepareStatement(deleteWineById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("number rows deleted: " + updateRowCount);
			} catch (SQLException e ) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return wineToDelete;
	}

	@Override
	public Wine updateWine(Wine updateWine) {
		List<Wine> wines = getWinesById(updateWine.getId());
		
		if (wines.size() > 0) {
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDBUtil.getConnection();
			try {
				ps = conn.prepareStatement(updateWineById);
				ps.setString(1, updateWine.getName());
				ps.setInt(2, updateWine.getVintage());
				ps.setString(3, updateWine.getVarietal().toString());
				ps.setString(4, updateWine.getRegion().toString());
				ps.setInt(5, updateWine.getQuantity());
				ps.setBigDecimal(6, updateWine.getPrice());
				ps.setString(7, updateWine.getNotes());
				ps.setInt(8, updateWine.getId());
				updateRowCount = ps.executeUpdate();
				System.out.println("number rows updated: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateWine;
	}

	@Override
	public List<Wine> report(Integer startVintage, Integer endVintage) {
		List<Wine> myWines = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDBUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectWinesByRangeOfVintage);
			ps.setInt(1, startVintage);
			ps.setInt(2, endVintage);
			rs = ps.executeQuery();
			myWines = makeWine(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return myWines;
	}
	
	private int getNewWineId(Connection conn) {
		ResultSet rs = null;
		Statement s = null;
		int newWineId = 0;
		
		try {
			s = conn.createStatement();
			rs = s.executeQuery(selectNewWineId);
			while(rs.next()) {
				newWineId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				s.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newWineId;
	}


	
	
}
