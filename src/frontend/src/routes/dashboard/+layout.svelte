<script lang="ts">
    import { onMount } from 'svelte';
    import { goto } from '$app/navigation';
    import { auth } from '$lib/stores/auth';
    
    let isLoading = true;
    
    onMount(() => {
      // Initialize the auth store
      auth.initialize();
      
      // Subscribe to auth store changes
      const unsubscribe = auth.subscribe(state => {
        isLoading = state.loading;
        
        // Redirect to login if not authenticated and not loading
        if (!state.loading && !state.isAuthenticated) {
          goto('/login');
        }
      });
      
      return () => {
        unsubscribe();
      };
    });
  </script>
  
  {#if isLoading}
    <div class="min-h-screen flex items-center justify-center bg-gray-100">
      <div class="flex flex-col items-center justify-center">
        <svg class="animate-spin -ml-1 mr-3 h-10 w-10 text-talkup-blue" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
          <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
          <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
        </svg>
        <p class="mt-4 text-lg text-gray-700">Loading...</p>
      </div>
    </div>
  {:else}
    <slot />
  {/if}