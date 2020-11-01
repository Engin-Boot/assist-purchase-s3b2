import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/product.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-alter-product',
  templateUrl: './alter-product.component.html',
  styleUrls: ['./alter-product.component.scss']
})
export class AlterProductComponent implements OnInit {

 
  /*product = {
    name: '',
    price: 100,
    wireless: false,
    touchscreen : false,
    interoperable : false
  };*/
  product=null;
  message = '';
  submitted = false;

  constructor(private productservice: ProductService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message='';
    this.product.id=this.route.snapshot.params['id'];
  }
  saveProduct() {
    const data = {
      name: this.product.name,
      price: this.product.price,
      wireless: this.product.wireless,
      touchscreen: this.product.touchscreen,
      interoperable: this.product.interoperable
    };

    this.productservice.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  /*newProduct() {
    this.submitted = false;
    this.product = {
      
    };
  }*/
  updateProduct() {
    this.productservice.update(this.product.id, this.product)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The tutorial was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteProduct() {
    this.productservice.delete(this.product.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/products']);
        },
        error => {
          console.log(error);
        });
  }

}
