import FoodRepository from "../repository/FoodRepository.js"

class FoodService{

    static async buscaTodas(){
        const list = await FoodRepository.buscaTodas()
        return list
    }

    static async buscaPorId(id){
        const find = await FoodRepository.buscaPorId(id)

        if(!find) throw new Error("not found")
        
        return find
    }

    static async criaFood(request){
        try {
            const food = await FoodRepository.criaFood(request);
            return food;
        } catch (error) {
            if (error.code === 'P2002') {
                throw new Error('Já existe uma comida com esse nome!');
            }
            throw error;
        }
    }

    static async edita(request){
        try{
            const food = await FoodRepository.edita(request)
            return food
        }catch(error){
            if(error.code === 'P2002') throw new Error("Já existe uma comida com esse nome")
        }
    }

    static async deleta(id){
        await FoodRepository.deleta(id)
    }
}
export default FoodService