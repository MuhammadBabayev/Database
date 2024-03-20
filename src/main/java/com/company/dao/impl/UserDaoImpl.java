package com.company.dao.impl;

import com.company.bean.Skill;
import com.company.bean.User;
import com.company.bean.UserSkill;
import com.company.dao.inter.AbstarctDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstarctDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profile_description = rs.getString("profile_description");
        Date birthdate = rs.getDate("birthdate");
        String adress = rs.getString("adress");
        String country = rs.getString("country");
        String nationality = rs.getString("nationality");

        return new User(id, name, surname, phone, email, profile_description, birthdate, adress, country, nationality);

    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("Select * from user");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name = ?,surname=?,phone=?,email=?,profile_description=?,birthdate=?,adress=?,country=?,nationality=? where id = ?");

            stmt.setString(1, u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfile_description());
            stmt.setDate(6, u.getBirthdate());
            stmt.setString(7, u.getAdress());
            stmt.setString(8, u.getCountry());
            stmt.setString(9, u.getNationality());
            stmt.setInt(10, u.getId());
            

            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id =" + id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id=" + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                result = getUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO user (name, surname, phone, email,country_id, nationality_id) values(?,?,?,?,?,?)");

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getCountry());
            stmt.setString(6, u.getNationality());

            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
    }

    public List<UserSkill> getAllSkillByUserId(int userId) {

        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT u.*,us.skill_id,s.name as skill_name,us.power\n"
                    + "from \n"
                    + "user_skill us\n"
                    + "left join user u on us.user_id=u.id\n"
                    + "left join skill s on us.skill_id=s.id \n"
                    + "where 	us.user_id=" + userId);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    

   

}
