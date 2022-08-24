package com.FinalProject.EmployeeManagementSystem.Controllers;

import com.FinalProject.EmployeeManagementSystem.Models.Assets;
import com.FinalProject.EmployeeManagementSystem.Models.Employee;
import com.FinalProject.EmployeeManagementSystem.Services.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Assets")
public class AssetsController {
    @Autowired
    private AssetsService assetsService;

    public void assetsController(AssetsService assetsService){
        this.assetsService=assetsService;
    }
    @GetMapping
    public ResponseEntity< List<Assets>> getAllAssets(){
        List<Assets>  assets=assetsService.getAllAssets();
        if(assets.size()>0){
            return new ResponseEntity<>(assets,HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveAssets(@RequestBody Assets assets){

        if (assets.getAssetsId().length()>0 && assets.getAssetsName().length()>0 && assets.getAssetsCurrentPrice()>0
        && assets.getAssetsPurchasePrice()>0){
            Assets asset= assetsService.saveAssets(assets);
            return new ResponseEntity<>("Created",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Please Enter valid Data",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public  ResponseEntity<Assets> getAssetsById(@PathVariable("id")int id)
    {
    try{
        return new ResponseEntity<Assets>(assetsService.getAssetsById(id),HttpStatus.OK);
    }
    catch (NoSuchElementException e){
        return new ResponseEntity<Assets>(HttpStatus.NOT_FOUND);
    }
    }

    @PutMapping("{id}")
    public  ResponseEntity<Assets> updateAssets(@PathVariable("id")int id, @RequestBody Assets assets)
    {
        try{
            return new ResponseEntity<Assets>(assetsService.updateAssets(assets, id), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAssets(@PathVariable("id")int id)
    {
        try{
            assetsService.deleteAssets(id);
            return new ResponseEntity<String>("id no."+id+" deleted successfully in Assets",HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
