import { PrismaClient } from "../../generated/prisma";
import Food from "../model/Food";

const prisma = new PrismaClient()

class FoodRepository{

    static async buscaTodas(){
        const list = await prisma.food.findMany()
        return list.map(f => new Food(f.id, f.nome, f.descricao, f.preco, f.disponivel))
    }

    static async criaFood(request){
        const save = await prisma.food.create({
            data:{
                nome: request.nome,
                descricao: request.descricao,
                preco: request.preco,
                disponivel: true
            }
        })

        return new Food(save.id, save.nome, save.descricao, save.preco, save.disponivel)
    }

    static async buscaPorId(idSearch){
        const find = await prisma.food.findUnique({
            where: { id }
        });
        
        if(!find) return null

        return new Food(find.id, find.nome, find.descricao, find.preco, find.disponivel)
    }

    static async edita(request){
        const atualizado = await prisma.food.update({
        where: { id: request.id },
         data: {
            nome: request.nome,
            descricao: request.descricao,
            preco: request.preco,
            disponivel: request.disponivel
        }
    });

        return new Food(atualizado.id, atualizado.nome, atualizado.descricao, atualizado.preco, atualizado.disponivel)
    }

    static async deleta(idDelete){
        await prisma.food.delete({
            where:{
                id : idDelete
            }
        })
    }
}

export default FoodRepository