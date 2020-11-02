import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-display-filtered-products',
  templateUrl: './display-filtered-products.component.html',
  styleUrls: ['./display-filtered-products.component.css']
})
export class DisplayFilteredProductsComponent implements OnInit {

  products:Product[]=new Array;
  constructor(private productService:ProductService,private router:Router) { }

  ngOnInit(): void {
    this.getProducts();
  }
  private getProducts():void
  {
    this.productService.getFilteredProductList().subscribe(data => {
      this.products = data});
  //    return this.products;
}
updateProduct(id: number){
  this.router.navigate(['update-product',id]);
}
deleteProduct(id: number){
  this.productService.deleteProduct(id).subscribe( data => {
    console.log(data);
    this.getProducts();
  })
}

}
