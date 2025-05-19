import foodRoutes from "./FoodRouter.js";

const routes = (app) => {
    app.use(foodRoutes)
}

export default routes