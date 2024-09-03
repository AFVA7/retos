<template>
  <div class="d-flex justify-content-center align-items-center min-vh-100">
    <div class="card p-4" style="width: 300px">
      <h1 class="text-center">Bienvenido</h1>

      <label for="inputPassword5" class="form-label">Ingresa tu nombre</label>
      <input
        type="password"
        id="inputPassword5"
        class="form-control"
        aria-describedby="passwordHelpBlock"
        v-model="nombre"
      />
      <button @click="saludar" class="btn btn-primary w-100 mt-3">
        Saludar
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import axios from "axios";
import { ref } from "vue";

const nombre = ref("");

async function saludar() {

    try {
        const saludo = await axios.get(
            `http://localhost:8080/saludo?nombre=${nombre.value}`,
            {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem("token")}`,
                },
            }
        );
        console.log(saludo);
        alert(saludo.data);
    } catch (error) {
        console.error(error);
        alert((error as any).response.data);

    }

}
</script>
