/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.Request;

import com.fenoreste.rest.ResponseDTO.destinationDocumentIdDTO;

/**
 *
 * @author wilmer
 */
public class ThirdPartyProduct {

    String productNumber;
    Integer productTypeId;
    destinationDocumentIdDTO productOwnerDocumentId;
    Integer thirdPartyProductType;

    public ThirdPartyProduct() {
    }

    public ThirdPartyProduct(String productNumber, Integer productTypeId, destinationDocumentIdDTO productOwnerDocumentId, Integer thirdPartyProductType) {
        this.productNumber = productNumber;
        this.productTypeId = productTypeId;
        this.productOwnerDocumentId = productOwnerDocumentId;
        this.thirdPartyProductType = thirdPartyProductType;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public destinationDocumentIdDTO getProductOwnerDocumentId() {
        return productOwnerDocumentId;
    }

    public void setProductOwnerDocumentId(destinationDocumentIdDTO productOwnerDocumentId) {
        this.productOwnerDocumentId = productOwnerDocumentId;
    }

    public Integer getThirdPartyProductType() {
        return thirdPartyProductType;
    }

    public void setThirdPartyProductType(Integer thirdPartyProductType) {
        this.thirdPartyProductType = thirdPartyProductType;
    }
    
    

}
