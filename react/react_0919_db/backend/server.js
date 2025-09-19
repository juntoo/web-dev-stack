const express = require("express");
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
app.use( cors() );
app.use( express.json() );

//DB연결 정보
const db = mysql.createConnection({ 
    host: 'localhost',
    user: 'root',
    password: 'qwer1234',
    database: 'signup'
 })

//DB접속 및 쿼리 요청
app.post( "/signup", (req, res)=>{ 
    const sql = "insert into login (`name`, `email`, `password`) values (?)";

    const values = [
        req.body.name,
        req.body.email,
        req.body.password
    ]

    db.query( sql, [values], ( err, data )=>{ 
        if( err ){
            console.error("DB Error:", err)
            return res.status(500).json(err)
            //return res.json("Errrrrror");
        }
        return res.json( data );
    } )

} )

app.post( "/login", (req, res)=>{
    const sql = "select * from login where `email`= ? and `password` = ?"

    const values = [
        req.body.email,
        req.body.password
    ]

    db.query( sql, values, ( err, data )=>{
        if( err ){
            return res.json("Errrrrror");
        }

        if( data.length > 0 ){
            res.json( "success" )
        }else {
            res.json( "fail" )
        }
    } )
} )

app.listen( 3000, ()=>{ 
    console.log("리슨리슨아이캔트리슨")
} )