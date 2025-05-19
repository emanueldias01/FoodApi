import express from 'express'
import routes from './route/index.js'

const app = express()

app.use(express.json())
routes(app)

export default app