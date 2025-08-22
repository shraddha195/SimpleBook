import { Injectable } from '@angular/core';

export class Book {
  Bookno?: number;
  title!: string;
  author!: string;
  price!: number;
  receiveDate!: Date;
  removingDate!: Date;
}

