<script lang="ts">
    import { onMount } from 'svelte';
    import { goto } from '$app/navigation';
    import { auth } from '$lib/stores/auth';
    
    let isLoading = true;
    
    onMount(() => {
      const unsubscribe = auth.subscribe(state => {
        isLoading = state.loading;
        
        // Check if not admin role
        if (!state.loading && (!state.isAuthenticated || state.user.role !== 'ADMIN')) {
          goto('/dashboard'); // Redirect to general dashboard
        }
      });
      
      return () => {
        unsubscribe();
      };
    });
  </script>
  
  {#if isLoading}
    <div class="flex items-center justify-center h-24">
      <svg class="animate-spin h-8 w-8 text-talkup-blue" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
        <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
        <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
      </svg>
    </div>
  {:else}
    <slot />
  {/if}