package pageObjects.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePage {
	WebDriver driver;

	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getUserNumberFromUI() {
		waitForElementVisible(driver, AdminUserPageUI.TOTAL_USER_NUMBER);
		String totalNumber = getElementText(driver, AdminUserPageUI.TOTAL_USER_NUMBER);
		return Integer.parseInt(totalNumber.split(" ")[0]);
	}

	public int getUserNumberFromDB() {
		Connection connect = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		List<Integer> totalUsers = new ArrayList<Integer>();
		try {
			statement = connect.createStatement();
			String sql = "SELECT * FROM wp_users";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				totalUsers.add(result.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalUsers.size();
	}
}
