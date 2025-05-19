import FoodService from "../service/FoodService.js"
import RequestFoodDTO from "../dto/ResponseFoodDTO.js"

class FoodController{

    static async buscaTodas(req, res){
        const list = await FoodService.buscaTodas()
        res.status(200).json(list)
    }

    static async buscaPodId(req, res){
        try{
            const id = Number(req.params.id)
            if(isNaN(id)){
                res.status(400).json({ mensagem: 'ID inválido' })
                return
            } 
            const find = await FoodService.buscaPorId(id)
            res.status(200).json(find)
        }catch(error){
            res.status(404).json({mensagem : `erro: ${error}`})
        }
    }

    static async cria(req, res){
        try{
            const body = req.body
            const request = new RequestFoodDTO(body.nome, body.descricao, body.preco)
            const food = await FoodService.criaFood(request)
            res.status(201).json(food)
        }
        catch(error){
            res.status(400).json({mensagem : `erro: ${error}`})
        }
    }

    static async atualiza(req, res){
        try{
            const body = req.body
            const food = await FoodService.edita(body)
            res.status(200).json(food)
        }catch(error){
            res.status(400).json({mensagem : `erro: ${error}`})
        }
    }

    static async deleta(req, res){
        const id = req.params.id
        await FoodService.deleta(id)

        res.status(204).send()
    }
}
export default FoodController