package com.trm.winecellar.dao;

import java.sql.Connection;
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
	
	private static String select = "SELECT id, name, price, varietal, purchaseDate, quantity, region";
	
	private static String selectAllWines = select + "FROM wines";
	
	private static String selectWinesByVintage = select + "FROM wines" +
	"WHERE vintage= ?";

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
		List<Wine> myWineList = new ArrayList<Wine>();
		while(result.next()) {
			Wine wine = new Wine();
			wine.setId(result.getInt("id"));
			wine.setName(result.getString("name"));
			wine.setPrice(result.getBigDecimal("price"));
			//wine.setVarietal(result.getString(Varietal "varietal"));
			wine.setVintage(result.getInt("vintage"));
			wine.setDescription(result.getString("description"));
			
			
			
			myWineList.add(wine);
			
		}
		return myWineList;
	}

	@Override
	public List<Wine> getWinesByVintage(Integer vintage) {
		List<Wine> myWineList = new ArrayList<Wine>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MySqlDBUtil.getConnection();
		
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectWinesByVintage);
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

	@Override
	public List<Wine> getWinesByRegion(Region region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wine> getWinesByVarietal(Varietal varietal) {
		// TODO Auto-generated method stub
		return null;
	}

}
