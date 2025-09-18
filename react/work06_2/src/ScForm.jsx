import React from "react";

function ScForm( {taskArr, delTask} ) {
    return (
        <table border='1'>
          <thead>
            <tr>
              <th>할 일</th>
              <th>마감일</th>
              <th>비고</th>
            </tr>
          </thead>

          <tbody>
            {
              taskArr.map( (t, index) => (
                <tr>
                  <td>{t.task}</td>
                  <td>{t.dueDate}</td>
                  <td><button onClick={ () => {delTask(index)} }>삭제</button></td>
                </tr>
              ) )
            }
          </tbody>
      </table>
    )
}

export default ScForm;