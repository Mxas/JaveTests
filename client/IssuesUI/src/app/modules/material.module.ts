import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {
	MatButtonModule, MatCardModule, MatDialogModule, MatInputModule, MatPaginatorModule, MatSortModule, MatTableModule,
	MatToolbarModule,
} from '@angular/material';

@NgModule({
  imports: [CommonModule, MatToolbarModule, MatButtonModule, MatCardModule, MatInputModule, MatDialogModule, MatTableModule, MatPaginatorModule, MatSortModule],
  exports: [CommonModule, MatToolbarModule, MatButtonModule, MatCardModule, MatInputModule, MatDialogModule, MatTableModule, MatPaginatorModule, MatSortModule],
})
export class CustomMaterialModule { }
