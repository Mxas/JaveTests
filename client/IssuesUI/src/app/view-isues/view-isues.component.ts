import {Component, OnInit, ViewChild} from '@angular/core';
import {Issue} from '../model/Issue';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
	selector: 'app-view-isues',
	templateUrl: './view-isues.component.html',
	styleUrls: ['./view-isues.component.css'],
})
export class ViewIsuesComponent implements OnInit {

	displayedColumns: string[] = ['id', 'no', 'caption', 'description'];

	issues = new MatTableDataSource<Issue>(ELEMENT_DATA);

	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;

	constructor() {
	}

	ngOnInit() {
		this.issues.paginator = this.paginator;
		this.issues.sort = this.sort;

	}

}

const ELEMENT_DATA: Issue[] =
	[{id: '1', no: 'Dhiraj', caption: 'Ray', description: 'dhiraj@gmail.com'},
		{id: '1', no: 'Tom', caption: 'description', description: 'Tom@gmail.com'},
		{id: '1', no: 'Hary', caption: 'description', description: 'hary@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
		{id: '1', no: 'praks', caption: 'description', description: 'praks@gmail.com'},
	];
