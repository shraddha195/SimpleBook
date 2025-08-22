package com.example.LabraryManageSystem;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	

	@Entity
	@Table(name="BookTable")
	public class Book {
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		@Column(name="Bookno",nullable=false)
		private Long Bookno;
		
		@Column(name="Name",nullable=false)
		private String name;
		
		@Column(name="Authorname")
		private String Authorname;
		
		@Column(name="Price")
		private String Price;
		
		@Column(name="ReceiveDate")
		private Date ReceiveDate;
		
		@Column(name="RemovingDate")
		private Date RemovingDate;

		public Book(Long bookno, String name, String authorname, String price, Date receiveDate, Date removingDate) {
			Bookno = bookno;
			name = name;
			Authorname = authorname;
			Price = price;
			ReceiveDate = receiveDate;
			RemovingDate = removingDate;
		}

		public Book() {}

		public Long getBookno() {
			return Bookno;
		}

		public void setBookno(Long bookno) {
			Bookno = bookno;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthorname() {
			return Authorname;
		}

		public void setAuthorname(String authorname) {
			Authorname = authorname;
		}

		public String getPrice() {
			return Price;
		}

		public void setPrice(String price) {
			Price = price;
		}

		public Date getReceiveDate() {
			return ReceiveDate;
		}

		public void setReceiveDate(Date receiveDate) {
			ReceiveDate = receiveDate;
		}

		public Date getRemovingDate() {
			return RemovingDate;
		}

		public void setRemovingDate(Date removingDate) {
			RemovingDate = removingDate;
		}

		

		@Override
		public int hashCode() {
			return Objects.hash(Authorname, Bookno, Price, ReceiveDate, RemovingDate, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return Objects.equals(Authorname, other.Authorname) && Objects.equals(Bookno, other.Bookno)
					&& Objects.equals(Price, other.Price) && Objects.equals(ReceiveDate, other.ReceiveDate)
					&& Objects.equals(RemovingDate, other.RemovingDate) && Objects.equals(name, other.name);
		}

		@Override
		public String toString() {
			return "Book [Bookno=" + Bookno + ", name=" + name + ", Authorname=" + Authorname + ", Price=" + Price
					+ ", ReceiveDate=" + ReceiveDate + ", RemovingDate=" + RemovingDate + "]";
		}
		
		
		
		
	}
