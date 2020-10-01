<template>
    <div>
        <div class="hello">
            <h1>Hello world!</h1>
        </div>
        <section class="todoapp">
            <div v-if="loading">
                <h1 class="loading">Loading...</h1>
            </div>
            <div v-else>
                <h2>Persons</h2>
                <ul class="persons-list">
                    <li v-for="person in persons"
                        class="person"
                        :key="person.id"
                        >
                        <p> {{ person.name }} </p>
                        <p> {{ person.born }} </p>
                    </li>
                </ul>
            </div>
        </section>
    </div>
</template>

<script>
import api from '../Api';

export default {
    name: 'HelloWorld',
    props: {
        msg: String
    },

    // app initial state
    data: function() {
        return {
            persons: [],
            loading: true,
            error: ""
        }
    },

    mounted() {
      api.getAllPersons()
        .then(response => {
          console.log("Data loaded: ", response.data);
          this.persons = response.data;
          console.log("first person: " + this.persons[0]);
      })
        .catch(error => {
          console.log(error);
          this.error = "Failed to load persons";
      })
        .finally(() => this.loading = false)
    },

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
