import React from "react";

const ToDo = ({toDoList, toDoDel}) => {

    function list(list) {
        return (
            list.map(
                (li, index) => (
                <tr>
                    <td>{li.toDo}</td>
                    <td>{li.endDate}</td>
                    <td>
                    <button onClick={()=>{toDoDel(index)}}>삭제</button>
                    </td>
                </tr>
                )
            )
        )
    }

    return (
        <table border="1">
          <tr>
            <th>할 일</th>
            <th>마감일</th>
            <th>작업</th>
          </tr>
          {list(toDoList)}
        </table>
    )
}

export default ToDo;

{/* <div>
            <table border="1">
                <tr>
                <th>할 일</th>
                <th>마감일</th>
                <th>작업</th>
                </tr>

                {
                list.map(
                    (li, index) => (
                    <tr>
                        <td>{li.toDo}</td>
                        <td>{li.endDate}</td>
                        <td>
                        <button onClick={()=>{toDoDel(index)}}>삭제</button>
                        </td>
                    </tr>
                    )
                )
                }
            </table>
        </div> */}