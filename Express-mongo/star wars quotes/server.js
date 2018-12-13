const express = require('express')
const bodyParser= require('body-parser')
const app = express()
const MongoClient = require('mongodb').MongoClient
var db
var collection

MongoClient.connect('mongodb://root:pwroot1@ds231374.mlab.com:31374/quotes', function(err, database) {
    if (err) return console.log(err)
    db = database.db('quotes')

    app.listen(3000, function(){
        console.log('listening on port 3000')
    })
})

app.use(bodyParser.urlencoded({extended: true}))

app.set('view engine', 'ejs')

app.post('/quotes', (req, res) => {
    collection = db.collection('starwars quotes').save(req.body, (err, result) => {
        if(err) return console.log(err)

        console.log('saved to db')
        res.redirect('/')
        res.render(view, locals)
    })
    console.log(req.body)
})

app.get('/', (req, res) => {
    db.collection('starwars quotes').find().toArray((err, result) => {
        if(err) return console.log(err)
        res.render('index.ejs', {quotes: result})
    })
})