import express from 'express'
import FoodController from '../controller/FoodController.js'

const foodRoutes = express.Router()

foodRoutes.get('/food', FoodController.buscaTodas)
foodRoutes.get('/food/:id', FoodController.buscaPodId)
foodRoutes.post('/food', FoodController.cria)
foodRoutes.put('/food', FoodController.atualiza)
foodRoutes.delete('/food/:id', FoodController.deleta)

export default foodRoutes