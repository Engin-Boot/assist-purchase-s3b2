import { Injectable } from '@angular/core';
import { Product } from './product';
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Displayproduct } from './displayproduct';
import { templateJitUrl } from '@angular/compiler';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient) { }
 
  getProductList(): Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>("http://localhost:8080/purchase/admin"));
    return this.httpClient.get<Product[]>("http://localhost:8080/purchase/admin");
  }
  
}
