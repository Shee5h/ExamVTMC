import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../services/AuthService";
import BookService from "../services/BookService";
import { useForm } from "react-hook-form";
import { v4 as uuid } from 'uuid';
import "./AdminBoard.css"
import CategoryService from "../services/CategoryService";

export default function AdminBoard() {

    const [books, setBooks] = useState([]);
    const [categories, setCategories] = useState([]);
    const {
        register,
        handleSubmit,
        formState: { errors } } = useForm({ mode: 'onSubmit', reValidateMode: 'onSubmit' });
    const user = AuthService.getCurrentUser();
    const navigate = useNavigate();

    // a function to check if the user is an administrator
    useEffect(() => {
        if (user !== null) {
            if (!(user.roles.includes("ROLE_ADMIN"))) {
                console.log(user)
                alert("You are not an administrator!")
                navigate("/mainPage")
            }
        } else {
            navigate("/")
        }
    })

    // function to get all books
    useEffect(() => {
        BookService.getAllBooks().then((response) => {
            setBooks(response.data)
        })
        CategoryService.getAllCategories().then((response) => {
            setCategories(response.data)
        })
    }, [])

    // submit function
    const onSubmit = data => {
        BookService.saveBook(data);
        console.log(data);
    }

    function refreshPage() {
        window.location.reload(false);
    }

    return (
        <div>

            <div className="container-fluid">
                {/* <div><strong>Email: </strong>{user.email}</div>
                <div><strong>Id: </strong>{user.id}</div>
                <div>{user.username}</div>
                <div>{user.roles}</div> */}


                <div className="container">
                    <h4 className="af_name container mt-3">Kategorijų ID:</h4>
                    <table className="table table-striped container">
                        <thead>
                            <tr>
                                <th>Category ID</th>
                                <th>Category name</th>
                            </tr>
                        </thead>
                        <tbody>
                            {categories.map((category) => {
                                return (
                                    <tr key={category.categoryId + uuid()}>
                                        <td>{category.categoryId}</td>
                                        <td>{category.categoryName}</td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>

                </div>

                <h4 className="af_name container mt-3">Pridėti knygą:</h4>

                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-lg-12 col-11 px-0 ">
                            <div className="form-container mt-0 px-0">
                                <form className="form-horizontal" onSubmit={handleSubmit(onSubmit)}>
                                    <div className="row">
                                        <div className="form-group col-4">

                                            <input {...register("bookName", { required: true })} type="text" className="form-control p-0" placeholder="Knygos pavadinimas" />
                                            {errors?.codeName?.type === "required" && <p className="login_error_message">Įveskite knygos pavadinimą:</p>}

                                        </div>
                                        <div className="form-group col-4">


                                            <input {...register("summary", { required: true })} type="text" className="form-control p-0" placeholder="Santrauka" />
                                            {errors?.businessName?.type === "required" && <p className="login_error_message">Įveskite knygos santrauką</p>}

                                        </div>
                                        <div className="form-group col-4">


                                            <input {...register("isbn", { required: true })} type="number" className="form-control p-0" placeholder="Knygos ISBN" />
                                            {errors?.address?.type === "required" && <p className="login_error_message">Įveskite knygos ISBN</p>}

                                        </div>
                                        <div className="form-group col-4">


                                            <input {...register("pageCount", { required: true })} type="number" className="form-control p-0" placeholder="Knygos puslapių skaičius" />
                                            {errors?.address?.type === "required" && <p className="login_error_message">Įveskite knygos puslapių skaičių</p>}

                                        </div>
                                        <div className="form-group col-4">

                                            <input {...register("categoryId", { required: true })} type="number" className="form-control p-0" placeholder="Knygos kategoriją" />
                                            {errors?.address?.type === "required" && <p className="login_error_message">Įveskite knygos puslapių skaičių</p>}

                                            {/*^^^ TURĖJO BUTI SELECT SU KATEGORIJOMIS ^^^*/}
                                        </div>
                                    </div>
                                    <div className="row">
                                        <button type="submit" className="btn signin" onClick={refreshPage}>Pridėti</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <table className="table table-striped container">
                    <thead>
                        <tr>
                            <th>Book ID</th>
                            <th>Book name</th>
                            <th>Summary</th>
                            <th>Book ISBN</th>
                            <th>Book page count</th>
                            <th>Book category</th>
                        </tr>
                    </thead>
                    <tbody>
                        {books.map((book) => {
                            return (
                                <tr key={book.bookId + uuid()}>
                                    <td>{book.bookId}</td>
                                    <td>{book.bookName}</td>
                                    <td>{book.summary}</td>
                                    <td>{book.isbn}</td>
                                    <td>{book.pageCount}</td>
                                    <td>{book.bookCategory.categoryId}</td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>

            </div >

        </div >
    )
}