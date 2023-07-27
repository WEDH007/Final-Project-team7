package school_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class profile_management {
	
	public static void main(String[] args) {
		connectToDB();
	}	

	public static void connectToDB() {
		
		 	String url = "jdbc:mysql://localhost:3306/bookstore"; 
	        String username = "root";
	        String password = "password"; 

	        Connection conn = null;
	        Scanner scanner = new Scanner(System.in);

	        try {
	            // Register the JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Create the database connection
	            conn = DriverManager.getConnection(url, username, password);

	            // Connection successful
	            System.out.println("Connected to the database!");

	            Statement statement = conn.createStatement();
	            
	            System.out.println("1. Login");
	            System.out.println("2. Register");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            
	            if (choice == 1) {
	                System.out.print("Enter username: ");
	                String loginUsername = scanner.next();
	                System.out.print("Enter password: ");
	                String loginPassword = scanner.next();
	                if (authenticateUser(statement, loginUsername, loginPassword)) {
	                    System.out.println("Login successful!");
	                    // Perform operations for logged-in user
	                    displayUserInfo(statement, loginUsername);
	                    System.out.println("Do you want to edit your information? (yes/no): ");
	                    String editUserInfo = scanner.next().toLowerCase();
	                    if(editUserInfo.equals("yes")) {
	                    	editUserInfo(statement, loginUsername);
	                    }
	                    System.out.println("Do you want to add credit card information? (yes/no): ");
	                    String addCreditCard = scanner.next().toLowerCase();
	                    if(addCreditCard.equals("yes")) {
	                    	addCreditCardInfo(statement, loginUsername);
	                    }
	                } else {
	                    System.out.println("Invalid credentials. Login failed.");
	                }
	            } else if (choice == 2) {
	                System.out.print("Username: ");
	                String registerUsername = scanner.next();
	                System.out.print("Password: ");
	                String registerPassword = scanner.next();
	                System.out.print("First Name: ");
	                String registerFirstName = scanner.next();
	                System.out.print("Last Name: ");
	                String registerLastName = scanner.next();
	                System.out.print("Date of Birth (mm/dd/yyyy): ");
	                String registerDOB = scanner.next();
	                System.out.print("Email: ");
	                String registerEmail = scanner.next();
	                System.out.print("Phone Number: ");
	                String registerPhone = scanner.next();
	                registerUser(statement, registerUsername, registerPassword, registerFirstName, registerLastName, registerDOB, registerEmail, registerPhone);
	                System.out.println("Registration successful!");
	                // Perform operations for registered user
	            } else {
	                System.out.println("Invalid choice.");
	            }

	            conn.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        } finally {
	            scanner.close();
	        }
	            
	}
	// Authenticate user
	private static boolean authenticateUser(Statement statement, String username, String password) throws SQLException {
	    String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
	    ResultSet resultSet = statement.executeQuery(query);
	    return resultSet.next();
	}
	
	// Register user
	private static void registerUser(Statement statement, String username, String password, String firstName, String lastName, String DOB, String email, String phone) throws SQLException {
	    String query = "INSERT INTO user (username, password, first_name, last_name, date_of_birth, email, phone_number) VALUES ('" + username + "', '" + password + "', '" + firstName + "', '" + lastName + "', '" + DOB + "', '" + email + "', '" + phone + "')";
	    statement.executeUpdate(query);
	}
	
	private static int getUserId(Statement statement, String username) throws SQLException{
		int userId = -1;
		String query = "SELECT user_id FROM user WHERE username = '" + username + "'";
		ResultSet resultSet = statement.executeQuery(query);
		if(resultSet.next()) {
			userId = resultSet.getInt("user_id");
		}
		resultSet.close();
		return userId;
	}
	
	// Add this method to the profile_management class
	private static void editUserInfo(Statement statement, String username) {
	    Scanner scanner = new Scanner(System.in);
	    try {
	        int userId = getUserId(statement, username);

	        if (userId == -1) {
	            System.out.println("User not found.");
	            return;
	        }

	        System.out.println("Enter new first name (press enter to keep the current value):");
	        String newFirstName = scanner.nextLine();
	        System.out.println("Enter new last name (press enter to keep the current value):");
	        String newLastName = scanner.nextLine();
	        System.out.println("Enter new date of birth (mm/dd/yyyy) (press enter to keep the current value):");
	        String newDOB = scanner.nextLine();
	        System.out.println("Enter new phone number (press enter to keep the current value):");
	        String newPhone = scanner.nextLine();

	        // Construct the SQL query to update user information
	        String query = "UPDATE user SET ";
	        boolean hasUpdate = false;

	        if (!newFirstName.isEmpty()) {
	            query += "first_name = '" + newFirstName + "'";
	            hasUpdate = true;
	        }
	        if (!newLastName.isEmpty()) {
	            if (hasUpdate) {
	                query += ", ";
	            }
	            query += "last_name = '" + newLastName + "'";
	            hasUpdate = true;
	        }
	        if (!newDOB.isEmpty()) {
	            if (hasUpdate) {
	                query += ", ";
	            }
	            query += "date_of_birth = '" + newDOB + "'";
	            hasUpdate = true;
	        }
	        if (!newPhone.isEmpty()) {
	            if (hasUpdate) {
	                query += ", ";
	            }
	            query += "phone_number = '" + newPhone + "'";
	            hasUpdate = true;
	        }

	        // Only update if at least one field is changed
	        if (hasUpdate) {
	            query += " WHERE user_id = " + userId;
	            statement.executeUpdate(query);
	            System.out.println("User information updated successfully!");
	        } else {
	            System.out.println("No changes made to user information.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error updating user information: " + e.getMessage());
	    } finally {
	        scanner.close();
	    }
	}

	
	private static void addCreditCardInfo(Statement statement, String username) {
		Scanner scanner = new Scanner(System.in);
		try {
			
			int userId = getUserId(statement, username);
			
			if(userId == -1) {
				System.out.println("User not found. Cannot add credit card information.");
				return;
			}
			
			String query = "SELECT * FROM credit_card WHERE user_id = " + userId;
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				System.out.println("Credit card information already exists for this user.");
				return;
			}
			
			System.out.print("Enter your card number: ");
			String cardNumber = scanner.nextLine();
			System.out.print("Enter your expiration date (mm/yyyy): ");
			String expiryDate = scanner.nextLine();
			System.out.print("Enter CVV: ");
			String cvv = scanner.nextLine();
			
			query = "INSERT INTO credit_card (user_id, card_number, expiration_date, cvv) VALUES (" + userId + ", '" + cardNumber + "', '" + expiryDate + "', '" + cvv + "')";
			statement.executeUpdate(query);
			System.out.println("Credit card information added successfully!");
		} catch (SQLException e) {
			System.out.println("Error adding credit card information: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
	
	private static void displayUserInfo(Statement statement, String username) throws SQLException {
		String query = "SELECT * FROM user WHERE username = '" + username + "'";
		ResultSet resultSet = statement.executeQuery(query);
		if(resultSet.next()) {
			System.out.println("User Profile:");
			System.out.println("Username: " + resultSet.getString("username"));
			System.out.println("First Name: " + resultSet.getString("first_name"));
			System.out.println("Last Name: " + resultSet.getString("last_name"));
			System.out.println("Date of Birth: " + resultSet.getString("date_of_birth"));
			System.out.println("Email: " + resultSet.getString("email"));
			System.out.println("Phone Number: " + resultSet.getString("phone_number"));
		}
		resultSet.close();
	}

}
			

















