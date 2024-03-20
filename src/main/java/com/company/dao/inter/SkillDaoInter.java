package com.company.dao.inter;

import com.company.bean.Skill;
import java.util.List;

public interface SkillDaoInter {
    public List<Skill> getAllSkill();

    public Skill getBySkillId(int id);

    public boolean updateSkill(Skill u);

    public boolean addSkill(Skill u);

    public boolean removeSkill(int id);

}