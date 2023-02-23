<template>
    <div>
      <h2>Product Registation</h2>
<form @submit.prevent="save">
  <div class="form-group">
    <label>Product name</label>
    <input type="text" v-model="product.productname" class="form-control"  placeholder="Product name">
  
  </div>
  <div class="form-group">
    <label>Customer Address</label>
    <input type="text" v-model="product.productdesc" class="form-control"  placeholder="Description">
  
  </div>
 
  <div class="form-group">
    <label>Mobile</label>
    <input type="text" v-model="product.productprice" class="form-control"  placeholder="Price">
  
  </div>
 
  <button type="submit" class="btn btn-primary">Save</button>
</form>
 
 
      <h2>Product View</h2>
      <table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="product in result" v-bind:key="product.id">

          <td>{{ product.productid }}</td>
          <td>{{ product.productname }}</td>
          <td>{{ product.productprice }}</td>
          <td>{{ product.productdesc }}</td>
          <td>
            <button type="button" class="btn btn-warning" @click="edit(product)">Edit</button>
            <button type="button" class="btn btn-danger"  @click="remove(product)">Delete</button>
          </td>
        </tr>
    
  </tbody>
</table>
    
    </div>

</template>
  
  <script>
    import Vue from 'vue';
    import axios from 'axios';
 
     Vue.use(axios)
 
 
  export default {
    name: 'ProductCrud',
    data () {
      return {
        result: {},

        product:{
                  productid: '',
                  productname: '',
                  productdesc: '',
                  productprice: ''
 
 
        }
      }
    },
    created() {
        this.ProductLoad();
    },
    mounted() {
          console.log("mounted() called.......");
        
      },
 
    methods: {
           ProductLoad()
           {
                 const page = "http://localhost:8081/product";
                 axios.get(page)
                  .then(
                      ({data})=>{
                        console.log(data);
                        this.result = data;
                      }
                  );
           },
          
          
           save()
           {
            if(this.product.productid == '')
              {
                this.saveData();
              }
              else
              {
                this.updateData();
              }      
 
           },
           saveData()
           {
            axios.post("http://localhost:8081/product", this.product)
            .then(
              ({data})=>{
                alert("saveddddd");
                this.product.productid = '';
                this.product.productname = '';
                this.product.productdesc = '',
                this.product.productprice = ''
                this.ProductLoad();
              }
            )
 
           },
           edit(product)
           {
            this.product = product;
          
           },
           updateData()
           {
              const editrecords  = 'http://localhost:8081/product';
              axios.put(editrecords, this.customer)
              .then(
                ({data})=>{
                  this.product.productid = '';
                  this.product.productname = '';
                  this.product.productdesc = '',
                  this.product.productprice = ''
                  this.productid = ''
                  alert("Updated!!!");
                  this.ProductLoad();
                }
              );
 
           },
 
           remove(product){
 
             const url = `http://localhost:8084/api/v1/customer/deletecustomer/${product.productid}`;
              axios.delete(url);
              alert("Deleteddd");
              this.ProductLoad();
            }
      }
  }
  </script>