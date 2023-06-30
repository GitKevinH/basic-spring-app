To run this program follow these steps:

1. Download/clone the project into your computer
2. Once it is cloned, open the project with your IDE (or just use the terminal but make sure you're pointed in the project's root directory) and make sure the maven project is built. 'mvn clean install'
3. Once the project is built, you can run it using 'mvn spring-boot:run'
4. When the project runs, enter 'http://localhost:8080' into your webpage. The '8080' might be different depending on your PC setup.
5. From here, you want to add an author first (You can't have a book without an author to write it, right?) all you need is a name.
6. Once you're done adding the author, you can head back to the home page to add a book. Just add the book title and select the author from the drop down menu.
7. Once you've added a book you should see it auto-populate on the book list page. The same page will allow you to update and delete the entry, or add more entries.
8. You can also now go back to the author page and see all the books that correspond to the author. You will also be able to update and delete the author as well.
9. One thing you cannot do is delete and author when there is a book tied to the author. You must first delete the books related to the author, then you can delete the author, or else face world destruction.
10. Happy librarying!


How the Books porition works:

Adding a Book:
When you click on the "Add New Book" link, you're taken to the book creation form.
Fill in the details of the book, such as the title and author, in the form.
Submit the form, and the application processes the request.
The Book Controller's createBook() method is called, which saves the new book to the database using the Book Repository.
After saving the book, you're redirected to the book list page.
The newly added book is displayed in the book list with its ID, title, author, and actions (Edit and Delete links).


Deleting a Book:
On the book list page, each book entry has a "Delete" link next to it.
When you click on the "Delete" link for a specific book, the application processes the request.
The Book Controller's deleteBook() method is called, which deletes the selected book from the database using the Book Repository.
After deleting the book, you're redirected back to the book list page.
The deleted book is no longer displayed in the book list.


Editing a Book:
On the book list page, each book entry has an "Edit" link next to it.
When you click on the "Edit" link for a specific book, you're taken to the book update form.
The form is pre-populated with the current details of the selected book.
Modify the book details as desired in the form.
Submit the form, and the application processes the request.
The Book Controller's updateBook() method is called, which updates the book in the database with the new details using the Book Repository.
After updating the book, you're redirected back to the book list page.
The updated book details are reflected in the book list.



How the Author portion works:

Adding an Author:
To add a new author, you can follow a similar process as adding a book.
Click on the "Add New Author" link or button in the application.
You'll be directed to the author creation form.
Fill in the required details such as the author's name, bio, or any other relevant information.
Submit the form, and the application processes the request.
The Author Controller's createAuthor() method is called, which saves the new author to the database using the Author Repository.
After saving the author, you're redirected to the author list page.
The newly added author is displayed in the author list with their ID, name, and other details.

Deleting an Author:
On the author list page, each author entry will have a "Delete" link or button next to it.
When you click on the "Delete" link or button for a specific author, the application processes the request.
The Author Controller's deleteAuthor() method is called, which deletes the selected author from the database using the Author Repository.
After deleting the author, you're redirected back to the author list page.
The deleted author is no longer displayed in the author list.

Editing an Author:
Similar to editing a book, you can edit the details of an existing author.
On the author list page, each author entry has an "Edit" link or button next to it.
When you click on the "Edit" link or button for a specific author, you're taken to the author update form.
The form is pre-populated with the current details of the selected author.
Modify the author details as desired in the form.
Submit the form, and the application processes the request.
The Author Controller's updateAuthor() method is called, which updates the author in the database with the new details using the Author Repository.
After updating the author, you're redirected back to the author list page.
The updated author details are reflected in the author list.