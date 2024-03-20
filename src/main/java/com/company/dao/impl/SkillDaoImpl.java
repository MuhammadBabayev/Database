package com.company.dao.impl;

import com.company.bean.Skill;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.AbstarctDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl implements SkillDaoInter{
    
    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String skill = rs.getString("skill");
      

        return new Skill(id, skill);

    }
    
     private Connection connect() throws Exception {
         String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "Mizan_12";

        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    @Override
    public List<Skill> getAllSkill() {
          List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("Select * from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill u = getSkill(rs);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Skill getBySkillId(int id) {
       Skill result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill where id=" + id);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                result = getSkill(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateSkill(Skill u) {
         try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name = ? where id = ?");

            stmt.setString(1, u.getSkill());
            stmt.setInt(10, u.getId());
            

            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSkill(Skill u) {
    try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO skill (skill) values(?)");

            stmt.setString(1, u.getSkill());
          
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSkill(int id) {
    try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from skill where id =" + id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}