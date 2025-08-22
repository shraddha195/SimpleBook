import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../book';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-book-form',
standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './bookform.html',
  styleUrls: ['./bookform.css']
})
export class Bookform implements OnInit {
  Bookno?: number;
  saving = false;
  form!: FormGroup; // define form here but initialize later

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private api: BookService
  ) {}

  ngOnInit(): void {
    // Now initialize form properly
    this.form = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(2)]],
      author: ['', [Validators.required]],
      price: ['', [Validators.required]],
      receiveDate: ['', [Validators.required]],
      removingDate: ['', [Validators.required]],
    });

    const BookParam = this.route.snapshot.paramMap.get('Bookno');
    if (BookParam) {
      this.Bookno = +BookParam;

      this.api.getById(this.Bookno).subscribe((b: Book) => {
        this.form.patchValue({
          title: b.title,
          author: b.author,
          price: b.price,
          receiveDate: this.formatDate(b.receiveDate),
          removingDate: this.formatDate(b.removingDate)
        });
      });
    }
  }

  private formatDate(date: string | Date): string {
    const d = new Date(date);
    return d.toISOString().substring(0, 10); // yyyy-MM-dd format
  }

  submit() {
    if (this.form.invalid) return;

    this.saving = true;

    const dto = {
  title: this.form.value.title!,
  author: this.form.value.author!,
  price: Number(this.form.value.price!),
  receiveDate: this.form.value.receiveDate!,
  removingDate: this.form.value.removingDate!
};



    const req$ = this.Bookno
      ? this.api.update(this.Bookno, dto)
      : this.api.addNew(dto);

    req$.subscribe({
      next: () => {
        this.saving = false;
        this.router.navigate(['/']);
      },
      error: () => {
        this.saving = false;
        alert('Save failed');
      }
    });
  }

  cancel() {
    this.router.navigate(['/']);
  }
}
