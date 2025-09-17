import React, { useState } from "react";
import InputField from "./InputField";

const MovieForm = ({addMovie}) => {


    const [movieTitle, setMovieTitle] = useState('')
    const [movieYear, setMovieYear] = useState('')

    const [titleError, setTitleError] = useState('');
    const [yearError, setYearError] = useState('');

    const validateForm = () => {
        let validated = true;

        if(!movieTitle) {
            setTitleError("영화 제목을 입력하세요");
            validated = false;
        }

        if(!movieYear) {
            setYearError("개봉연도를 입력하세요");
            validated = false;
        }

        return validated;
    }

    const onSubmit = (e)=>{
        e.preventDefault();

        setTitleError('')
        setYearError('')

        if( validateForm() ) {
            addMovie({
                id: Date.now(),
                title: movieTitle,
                year:movieYear
            });
        }

        setMovieTitle('')
        setMovieYear('')
    }

    return (
        <form onSubmit={onSubmit}>

            <InputField value={movieTitle} 
                        placeholder="영화제목" 
                        onChange={(e)=>setMovieTitle(e.target.value)} 
                        errorMessage={titleError} />

            <InputField value={movieYear} 
                        placeholder="개봉연도" 
                        onChange={(e)=>setMovieYear(e.target.value)} 
                        errorMessage={yearError} 
                        type="number" />

            <input type='submit' value="영화등록" />
        </form>
    )
}

export default MovieForm;

/**
 * export default function MovieForm(){}
 */