package com.witty;

import cn.hutool.core.bean.BeanUtil;
import com.witty.controller.RoleController;
import com.witty.entity.Role;
import com.witty.entity.model.RoleModel;
import com.witty.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleControllerTest {
    @Autowired
    private RoleController roleController;

    @Test
    void batchCreate() {
        String fileName = "睿声AI-声音市场.xlsx";

        List<RoleModel> roleModels = ExcelUtils.readExcelToList(fileName, RoleModel.class);

        for (RoleModel roleModel : roleModels) {
            Role role = new Role();
            BeanUtil.copyProperties(roleModel, role);
            role.setCreateBy("admin");
            roleController.create(role);
        }

    }
}
