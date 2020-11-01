import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlterProductComponent } from './alter-product/alter-product.component';
import{ViewProductComponent} from './view-product/view-product.component';

const routes: Routes = [
  { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'alter', component: AlterProductComponent },
  { path: 'view', component: ViewProductComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
