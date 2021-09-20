<template>
  <div id="app">
    <Navigation></Navigation>
    <router-view/>
    <Footer></Footer>
  </div>
</template>

<script>
import Navigation from './components/Navigation'
import Footer from './components/Footer'
export default {
  name: 'app',
  components: {
    'Navigation': Navigation,
    'Footer': Footer
  }
}
</script>
