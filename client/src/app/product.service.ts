import { Injectable } from '@angular/core';
import { Product } from './product';
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
//import { Displayproduct } from './displayproduct';
import { templateJitUrl } from '@angular/compiler';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient) { }
 
  getAllProductList(): Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>("http://localhost:8080/purchase/admin"));
    return this.httpClient.get<Product[]>("http://localhost:8080/purchase/admin");
  }
  createProduct(product:Product) :Observable<Object>{
    return this.httpClient.post("http://localhost:8080/purchase/admin",product);
  }
  updateProduct(id: number, product:Product): Observable<Object>{
    return this.httpClient.put("http://localhost:8080/purchase/admin", product);
  }
  private homeURL="http://localhost:8080/purchase/admin"
  getProductById(id: number): Observable<Product>{
    
    return this.httpClient.get<Product>(`${this.homeURL}/${id}`);
  }
  deleteProduct(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.homeURL}/${id}`);
  }
}
