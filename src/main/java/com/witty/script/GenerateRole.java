package com.witty.script;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import com.witty.entity.Role;
import com.witty.entity.model.RoleModel;
import com.witty.utils.ExcelUtils;

import java.util.List;

public class GenerateRole {
    public static void main(String[] args) throws Exception {

        List<RoleModel> roleModels = ExcelUtils.readExcelToList("睿声AI-声音市场.xlsx", RoleModel.class);

        for (RoleModel roleModel : roleModels) {
            Role role = new Role();
            BeanUtil.copyProperties(roleModel, role);
            System.out.println(role);
        }
    }
}
