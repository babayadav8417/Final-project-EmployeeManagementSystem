package com.FinalProject.EmployeeManagementSystem.Services;

import com.FinalProject.EmployeeManagementSystem.Models.Assets;
import com.FinalProject.EmployeeManagementSystem.Repositories.AssetsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssetsServiceImpl implements AssetsService{
    @Autowired
    private AssetsRepo assetsRepo;
    public AssetsServiceImpl(AssetsRepo assetsRepo){
        this.assetsRepo=assetsRepo;
    }

    @Override
    public List getAllAssets() {
        return assetsRepo.findAll();
    }

    @Override
    public Assets getAssetsById(int id) {
        return assetsRepo.findById(id).orElseThrow();
    }

    @Override
    public Assets saveAssets(Assets assets) {
        return assetsRepo.save(assets);
    }

    @Override
    public Assets updateAssets(Assets assets, int id) {
        Assets existingAssets=assetsRepo.findById(id).orElseThrow();
        existingAssets.setAssetsName(assets.getAssetsName());
        existingAssets.setAssetsCurrentPrice(assets.getAssetsCurrentPrice());
        existingAssets.setAssetsPurchasePrice(assets.getAssetsPurchasePrice());
        existingAssets.setAssetsId(assets.getAssetsId());
        assetsRepo.save(existingAssets);
        return existingAssets;
    }
    @Override
    public void deleteAssets(int id) {
        assetsRepo.findById(id).orElseThrow();
        assetsRepo.deleteById(id);
    }
}
