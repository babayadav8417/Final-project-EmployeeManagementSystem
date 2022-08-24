package com.FinalProject.EmployeeManagementSystem.Services;

import com.FinalProject.EmployeeManagementSystem.Models.Assets;


import java.util.List;

public interface AssetsService {
    Assets saveAssets(Assets assets);
    List<Assets> getAllAssets();

    Assets getAssetsById(int id3);
    void deleteAssets(int id3);
    Assets updateAssets(Assets assets,int id3);
}
