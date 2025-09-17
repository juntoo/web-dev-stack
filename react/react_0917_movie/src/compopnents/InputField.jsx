import React from "react";

const InputField = 
( { value, placeholder, onChange, errorMessage, type } ) => {
    return (
        <div>
            <input placeholder={placeholder}
                   value={value}
                   onChange={onChange} 
                   type={type} />
            <br/>

            <div style={{color:'red'}}>
                {errorMessage}
            </div>
        </div>
    )
}

export default InputField;