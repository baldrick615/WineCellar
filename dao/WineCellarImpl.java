package com.trm.winecellar.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

public class WineCellarImpl implements WineDAO {
	
	private static String select = "SELECT id, name, price, vintage, varietal, purchaseDate, quantity, region, description ";
	
	private static String selectAllWines = select + "FROM wines ";
	
	private static String selectWinesById = select 
			+ "FROM wines "
			+ "WHERE id = ? ";
	
	private static String selectWinesByVintage = select 
			+ "FROM wines " 
			+ "WHERE vintage = ? ";
	
	private static String selectWinesByRegion = select + "FROM wines " +
			"WHERE region = ? ";
	
	private static String deleteWinesById = "DELETE FROM wines" +
			"WHERE id = ? ";
	
	private static String selectWinesByVarietal = select +
			"FROM wines " +
			"WHERE varietal = ? ";
	
	private static String selectWinesByRangeOfVintage = select
			+ "FROM wines "
			+ "WHERE vintage >= ? AND releaseYear <= ? ";
	
	private static String insertWine = "INSERT INTO wines (name, price, varietal, purchaseDate, quantity, region, description ) "
			+ "VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?) ";
	
	private static String updateWineById = 
			"UPDATE wines "
			+ "SET name = ?, "
			+ " vintage = ?, "
			+ " varietal = ?, "
			+ " price = ?, "
			+ " quantity = ?, "
			+ " region = ?, "
			+ " purchaseDate = ?, "
			+ " description = ?, "
			+ " WHERE id = ? ";
			
	
	private static String selectNewWineId = "SELECT LAST_INSERT_ID() as 'id' ";

	@Override
	public List<Wine> getWines() {
		List<Wine> myWineList = new ArrayList<Wine>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MySqlDBUtil.getConnection();
		
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllWines);
			myWineList = makeWineList(result);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return myWineList;
	}

	private List<Wine> makeWineList(ResultSet result) throws SQLException {
		List<Wine> wineList = new ArrayList<Wine>();
		while(result.next()) {
			Wine wine = new Wine();
			wine.setId(result.getInt("id"));
			wine.setName(result.getString("name"));
			wine.setPrice(result.getBigDecimal("price"));
			String regionString = result.getString("region");
			wine.setRegion(Region.convertStringToRegion(regionString));
			wine.setVintage(result.getInt("vintage"));
			wine.setDescription(result.getString("description"));
			wine.setQuantity(result.getInt("quantity"));
			String varietalString = result.getString("varietal");
			wine.setVarietal(Varietal.convertStringtoVarietal(varietalString));
			wine.setPurchaseDate(result.getObject("purchaseDate", LocalDate.class));
			wineList.add(wine);
		}
		return wineList;
	}

	@Override
	public List<Wine> getWinesByVintage(Integer vintage) {
		List<Wine> wineList = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = MySqlDBUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectWinesByVintage);
			ps.setInt(1, vintage);
			rs = ps.executeQuery();
			wineList = makeWineList(rs);
		}
		catch (SQLException e) {
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
		return wineList;
	}

	@Override
	public List<Wine> getWinesByRegion(Region region) {
		List<Wine> wineList = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MySqlDBUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectWinesByRegion);
			ps.setString(1,  region.toString());
			rs = ps.executeQuery();
			wineList = makeWineList(rs);
		}
		catch (SQLException e) {
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
		return wineList;
	}

	@Override
	public List<Wine> getWinesByVarietal(Varietal varietal) {
		List<Wine> wineList = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MySqlDBUtil.getConnection();
				try {
					ps = conn.prepareStatement(selectWinesByVarietal);
					ps.setString(1, varietal.toString());
					rs = ps.executeQuery();
					wineList = makeWineList(rs);
				}
				catch (SQLException e) {
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
				return wineList;
			}

	@Override
	public List<Wine> getWinesById(Integer id) {
		List<Wine> wineList = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MySqlDBUtil.getConnection();
				try {
					ps = conn.prepareStatement(selectWinesById);
					ps.setInt(1, id);
					rs = ps.executeQuery();
					wineList = makeWineList(rs);
				}
				catch (SQLException e) {
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
				return wineList;
			}

	@Override
	public Wine createWine(Wine newWine) {
		PreparedStatement ps = null;
		
		Connection conn = MySqlDBUtil.getConnection();
		try {
			ps = conn.prepareStatement(insertWine);
			ps.setString(1, newWine.getName());
			ps.setInt(2, newWine.getVintage());
			ps.setString(3, newWine.getVarietal().toString());
			ps.setBigDecimal(4, newWine.getPrice());
			ps.setString(5, newWine.getRegion().toString());
			ps.setInt(6, newWine.getQuantity());
			ps.setString(7, newWine.getDescription());
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return newWine;
	}

	

	@Override
	public Wine updateWine(Wine updateWine) {
		List<Wine> wineList = getWinesById(updateWine.getId());
		Wine wine = null;
		if (wineList.size() > 0) {
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MySqlDBUtil.getConnection();
			try {
				ps = conn.prepareStatement(updateWineById);
				ps.setString(1, updateWine.getName());
				ps.setInt(2, updateWine.getVintage());
				ps.setString(3, updateWine.getVarietal().toString());
				ps.setBigDecimal(4, updateWine.getPrice());
				ps.setString(5, updateWine.getRegion().toString());
				ps.setInt(6, updateWine.getQuantity());
				ps.setString(7, updateWine.getDescription());
				
			}
			catch (SQLException e) {
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
	public List<Wine> deleteWineById(Integer id) {
		List<Wine> wineList = getWinesById(id);
		
		if (wineList.size() > 0) {
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MySqlDBUtil.getConnection();
			try {
				ps = conn.prepareStatement(deleteWinesById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
				
			}
			catch (SQLException e) {
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
		return wineList;
	}

	@Override
	public List<Wine> report(Integer startVintage, Integer endVintage) {
		List<Wine> wineList = new ArrayList<Wine>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = MySqlDBUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectWinesByRangeOfVintage);
			ps.setInt(1, startVintage);
			ps.setInt(2, endVintage);
			rs = ps.executeQuery();
			wineList = makeWineList(rs);
		} catch(SQLException e) {
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
		return wineList;
	}

	@Override
	public List<Wine> getWinesByPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
