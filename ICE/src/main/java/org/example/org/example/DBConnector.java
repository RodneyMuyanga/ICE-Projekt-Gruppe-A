package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DBConnector {
    //mysql:mysql-connector-java:RELEASE
    static final String DB_URL = "jdbc:mysql://localhost:3306/clothing";
    static final String USER = "root";
    static final String PASS = "Ch@d1234";
    //-------------MEN---------------//
    protected final ArrayList<Clothing> bootsForMen;
    protected final ArrayList<Clothing> hoodiesForMen;
    protected final ArrayList<Clothing> jacketsForMen;
    protected final ArrayList<Clothing> pantsForMen;
    protected final ArrayList<Clothing> sneakersForMen;
    protected final ArrayList<Clothing> tshirtsForMen;
    //-------------WOMEN---------------//
    protected final ArrayList<Clothing> bootsForWomen;
    protected final ArrayList<Clothing> hoodiesForWomen;
    protected final ArrayList<Clothing> jacketsForWomen;
    protected final ArrayList<Clothing> pantsForWomen;
    protected final ArrayList<Clothing> sneakersForWomen;
    protected final ArrayList<Clothing> tshirtsForWomen;
    //-------------KIDS---------------//
    protected final ArrayList<Clothing> bootsForKids;
    protected final ArrayList<Clothing> hoodiesForKids;
    protected final ArrayList<Clothing> jacketsForKids;
    protected final ArrayList<Clothing> pantsForKids;
    protected final ArrayList<Clothing> sneakersForKids;
    protected final ArrayList<Clothing> tshirtsForKids;
    //-------------ALL---------------//
    protected final ArrayList<Clothing> allMenClothes;
    protected final ArrayList<Clothing> allWomenClothes;
    protected final ArrayList<Clothing> allKidsClothes;
    protected final ArrayList<Clothing> allClothes;
    protected final ArrayList<Clothing> allRecycledClothes;
    //-------------USER---------------//
    protected ArrayList<User> guestUser;
    protected ArrayList<Clothing> RecyclingClothes;


    public DBConnector() {
        //-------------MEN---------------//
        this.bootsForMen = new ArrayList<>();
        this.hoodiesForMen = new ArrayList<>();
        this.jacketsForMen = new ArrayList<>();
        this.pantsForMen = new ArrayList<>();
        this.sneakersForMen = new ArrayList<>();
        this.tshirtsForMen = new ArrayList<>();
        //-------------WOMEN---------------//
        this.bootsForWomen = new ArrayList<>();
        this.pantsForWomen = new ArrayList<>();
        this.hoodiesForWomen = new ArrayList<>();
        this.jacketsForWomen = new ArrayList<>();
        this.sneakersForWomen = new ArrayList<>();
        this.tshirtsForWomen = new ArrayList<>();
        //-------------KIDS---------------//
        this.bootsForKids = new ArrayList<>();
        this.hoodiesForKids = new ArrayList<>();
        this.jacketsForKids = new ArrayList<>();
        this.pantsForKids = new ArrayList<>();
        this.sneakersForKids = new ArrayList<>();
        this.tshirtsForKids = new ArrayList<>();
        //-------------ALL---------------//
        this.allMenClothes = new ArrayList<>();
        this.allWomenClothes = new ArrayList<>();
        this.allKidsClothes = new ArrayList<>();
        this.allClothes = new ArrayList<>();
        this.allRecycledClothes = new ArrayList<>();
        //-------------USER---------------//
        this.guestUser = new ArrayList<>();
    }

    public void readRecycledClothes() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM recycledclothing";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String gender = rs.getString("gender");
                String size = rs.getString("size");
                String color = rs.getString("color");
                int price = rs.getInt("price");

                Clothing recycledClothing = new Clothing(brand, model,  gender,  size, color, price);
                allRecycledClothes.add(recycledClothing);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public ArrayList<Clothing> getAllRecycledClothes(){
        return allRecycledClothes;
    }

    public void saveRecycledClothes(String brand, String model, String gender, String size, String color, int price) {
        //Users userData = new Users();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //System.out.println("Connecting do database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO recycledclothing (brand, model, gender, size, color, price) VALUES(?,?,?,?,?,?)";
            stmt = conn.prepareStatement((sql));

            int ID = 0;
            stmt.setString(1,brand);
            stmt.setString(2,model);
            stmt.setString(3,gender);
            stmt.setString(4,size);
            stmt.setString(5,color);
            stmt.setInt(6,price);

            int rowsAffected = stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public void readMenBoots() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM boots WHERE gender= 'Men'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                int size = rs.getInt("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Boots boots = new Boots(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                bootsForMen.add(boots);
                allMenClothes.add(boots);
                allClothes.add(boots);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public ArrayList<Clothing> getBootsForMen() {
        return bootsForMen;
    }

    public void readMenHoodies() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM hoodies WHERE gender= 'Men'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Hoodies hoodies = new Hoodies(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                hoodiesForMen.add(hoodies);
                allMenClothes.add(hoodies);
                allClothes.add(hoodies);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
    public ArrayList<Clothing> getHoodiesForMen() {
        return hoodiesForMen;
    }

    public void readMenJackets() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM jacket WHERE gender= 'Men'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Jacket jacket = new Jacket(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                jacketsForMen.add(jacket);
                allMenClothes.add(jacket);
                allClothes.add(jacket);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
    public ArrayList<Clothing> getJacketsForMen() {
        return jacketsForMen;
    }

    public void readMenPants() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM pants WHERE gender= 'Men'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Pants pants = new Pants(id, price, discountPrice, stock, type, brand, genderResult, size, color, model);
                pantsForMen.add(pants);
                allMenClothes.add(pants);
                allClothes.add(pants);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
    public ArrayList<Clothing> getPantsForMen() {
        return pantsForMen;
    }

    public void readMenSneakers() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM sneakers WHERE gender= 'Men'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                int size = rs.getInt("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Sneakers sneakers = new Sneakers(id, price, discountPrice,stock, type, brand, genderResult, size, color, model);
                sneakersForMen.add(sneakers);
                allMenClothes.add(sneakers);
                allClothes.add(sneakers);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
    public ArrayList<Clothing> getSneakersForMen() {
        return sneakersForMen;
    }

    public void readMenTshirts() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM tshirt WHERE gender= 'Men'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Tshirt tshirt = new Tshirt (id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                tshirtsForMen.add(tshirt);
                allMenClothes.add(tshirt);
                allClothes.add(tshirt);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public ArrayList<Clothing> getTshirtsForMen() {
        return tshirtsForMen;
    }

    public void readBootsForKids() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM boots WHERE size < 35";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                int size = rs.getInt("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Boots bootsKids = new Boots(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                bootsForKids.add(bootsKids);
                allKidsClothes.add(bootsKids);
                allClothes.add(bootsKids);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public ArrayList<Clothing> getBootsForKids() {
        return bootsForKids;
    }

    public void readHoodiesForKids() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM hoodies WHERE size = 'S' OR size = 'XS'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Hoodies hoodieKids = new Hoodies(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                hoodiesForKids.add(hoodieKids);
                allKidsClothes.add(hoodieKids);
                allClothes.add(hoodieKids);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public ArrayList<Clothing> getHoodiesForKids() {
        return hoodiesForKids;
    }

    public void readJacketsForKids() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM jacket WHERE size = 'S' OR size = 'XS'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Jacket jacketKids = new Jacket(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                jacketsForKids.add(jacketKids);
                allKidsClothes.add(jacketKids);
                allClothes.add(jacketKids);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public ArrayList<Clothing> getJacketsForKids() {
        return jacketsForKids;
    }

    public void readPantsForKids() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM pants WHERE size = 'S' OR size = 'XS'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Pants pantsKids = new Pants(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                pantsForKids.add(pantsKids);
                allKidsClothes.add(pantsKids);
                allClothes.add(pantsKids);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }


    public void readTshirtForKids() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM tshirt WHERE size = 'S' OR size = 'XS'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                String size = rs.getString("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Tshirt tshirtKids = new Tshirt(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                tshirtsForKids.add(tshirtKids);
                allKidsClothes.add(tshirtKids);
                allClothes.add(tshirtKids);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    public void readSneakersForKids() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql =
                    "SELECT * FROM sneakers WHERE size = '7'";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int price = rs.getInt("price");
                int discountPrice = rs.getInt("discountPrice");
                int stock = rs.getInt("stock");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String genderResult = rs.getString("gender");
                int size = rs.getInt("size");
                String model = rs.getString("model");
                String color = rs.getString("color");

                Sneakers sneakersKids = new Sneakers(id, price, discountPrice,stock, type, brand,genderResult, size,color, model);
                sneakersForKids.add(sneakersKids);
                allKidsClothes.add(sneakersKids);
                allClothes.add(sneakersKids);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }


    public ArrayList<Clothing> getPantsForKids() {
        return pantsForKids;
    }
    public ArrayList<Clothing> getTshirtsForKids() {
        return tshirtsForKids;
    }
    public ArrayList<Clothing> getSneakersForKids() {
        return sneakersForKids;
    }

    public ArrayList<Clothing> getAllMenClothes() {
        return allMenClothes;
    }

    public ArrayList<Clothing> getAllKidsClothes() {
        return allKidsClothes;
    }

    public ArrayList<Clothing> getAllWomenClothes() {
        return allWomenClothes;
    }

    public ArrayList<Clothing> getAllClothes() {
        return allClothes;
    }

    public void readAllData(){
        //-----Men-----//
        readMenHoodies();
        readMenJackets();
        readMenPants();
        readMenBoots();
        readMenTshirts();
        readMenSneakers();
        //-----Women-----//

        //-----Kids-----//
        readBootsForKids();
        readJacketsForKids();
        readHoodiesForKids();
        readPantsForKids();
        readTshirtForKids();
        readSneakersForKids();

        readRecycledClothes();

    }
}