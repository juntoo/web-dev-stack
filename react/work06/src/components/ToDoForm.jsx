import React, { useState } from "react";

const ToDoForm = ({addToDo}) => {
    const [toDo, setToDo] = useState('');
    const [endDate, setEndDate] = useState('');


    const onSubmit = (e) => {
        e.preventDefault();
        addToDo({toDo: toDo, endDate: endDate})
        
        setToDo('')
        setEndDate('')
    }

    return (
        <form onSubmit={onSubmit}>
            <input placeholder="할 일을 입력하세요"
                value={toDo}
                onChange={(e)=>{setToDo(e.target.value)}}/>
            <br/>
            <input placeholder="마감일(예: 2025-09-20)"
                value={endDate}
                onChange={(e)=>{setEndDate(e.target.value)}}/>

            <input type="submit" value="추가" />
      </form>
    )
}

export default ToDoForm;