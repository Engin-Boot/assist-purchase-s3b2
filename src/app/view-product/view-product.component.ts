import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/product.service';
@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.scss']
})
export class ViewProductComponent implements OnInit {
  products: any;
  product = null;
  name='';

  constructor(private productservice: ProductService) { }

  ngOnInit(): void {
  }
  getallProduct() {
    this.productservice.getAll()
      .subscribe(
        data => {
          this.product = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  searchProduct() {
    this.productservice.findByName(this.name)
      .subscribe(
        data => {
          this.products = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
      }

}
