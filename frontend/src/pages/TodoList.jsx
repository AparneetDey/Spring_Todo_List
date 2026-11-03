import React, { useCallback, useEffect, useState } from 'react'
import api from '../utils/api';

const TodoList = () => {
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(true);
    const [todos, setTodos] = useState([]);

    const fetchTodos = useCallback(
        async () => {
            setLoading(true);
            setError("");
            try {
                const response = await api.get("/todo");

                console.log(response);
            } catch (error) {
                setError(error.message);
            }
        }, []
    )

    useEffect(() => {
        fetchTodos();
    }, [fetchTodos])



    return (
        <div>TodoList</div>
    )
}

export default TodoList