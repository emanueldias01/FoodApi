import { PrismaClient } from "../../generated/prisma";

const prisma = new PrismaClient()

class FoodRepository{

    static async buscaTodas(){
        const list = await prisma.food.findMany()
        return list
    }
}