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
  constructURL(product:Product):String{
    const baseURL='http://localhost:8080/purchase/admin';
    let params=new HttpParams();
    let fullURL:String;
    console.log(product.name,product.isTouchscreen,product.isWireless);
    if(product.name!=undefined&&product.name.length!=0)params=params.set('name',product.name.toString()); 
    if(product.isWireless!=undefined&&product.isWireless.length!=0)params=params.set('wireless',product.isWireless.toString());
    if(product.isTouchscreen!=undefined&&product.isTouchscreen.length!=0)params=params.set('touchscreen',product.isTouchscreen.toString());
    if(product.isInteroperable!=undefined&&product.isInteroperable.length!=0)params=params.set('interoperable',product.isInteroperable.toString());
    if(params.toString().length!=0) fullURL = `${baseURL}?${params.toString()}`;
    else fullURL = `${baseURL}${params.toString()}`;
    //console.log(params.toString());
    //console.log(product.isInteroperable.length);
//console.log({ fullURL });
return fullURL;
  }
  getFilteredProductList(product:Product): Observable<Product[]>{
    var newLocal = this.constructURL(product);
    console.log(newLocal);
    // console.log(this.httpClient.get<Product[]>(`${newLocal}`));
    return this.httpClient.get<Product[]>({newLocal});
  }  
}
