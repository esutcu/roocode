<script>
  import { page } from '$app/stores';
  import { onMount } from 'svelte';
  import { goto } from '$app/navigation';
  import { browser } from '$app/environment';
  
  let userRole = 'student'; // Default role
  
  if (browser) {
    onMount(() => {
      const storedRole = localStorage.getItem('userRole');
      if (storedRole) {
        userRole = storedRole;
      }
    });
  }
</script>

<div class="min-h-screen bg-gray-100">
  <nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between h-16">
        <div class="flex">
          <div class="flex-shrink-0 flex items-center">
            <img class="h-8 w-8" src="https://picsum.photos/seed/talkup/32/32.jpg" alt="TalkUp Logo" />
            <span class="ml-2 text-xl font-bold text-blue-600">TalkUp</span>
          </div>
        </div>
        <div class="flex items-center">
          <div class="flex space-x-4">
            <a href="/" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Home</a>
            <a href="/dashboard" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Dashboard</a>
            <a href="/credits" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Credits</a>
            <a href="/bookings" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Bookings</a>
            <a href="/settings" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Settings</a>
          </div>
        </div>
      </div>
    </div>
  </nav>
  
  <main class="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
    <div class="px-4 py-6 sm:px-0">
      <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6">
          <h1 class="text-lg leading-6 font-medium text-gray-900">Welcome to TalkUp</h1>
          <p class="mt-1 max-w-2xl text-sm text-gray-500">A platform for language learning and practice.</p>
        </div>
        <div class="border-t border-gray-200">
          <div class="px-4 py-5 sm:p-6">
            <p class="text-gray-500">Select a dashboard to get started:</p>
            <div class="mt-4 grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-4">
              <a href="/dashboard/student" class="bg-blue-50 border border-blue-200 rounded-lg p-4 flex flex-col items-center justify-center hover:bg-blue-100 transition-colors">
                <svg class="h-8 w-8 text-blue-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                </svg>
                <span class="mt-2 text-sm font-medium text-blue-800">Student Dashboard</span>
              </a>
              <a href="/dashboard/teacher" class="bg-green-50 border border-green-200 rounded-lg p-4 flex flex-col items-center justify-center hover:bg-green-100 transition-colors">
                <svg class="h-8 w-8 text-green-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                </svg>
                <span class="mt-2 text-sm font-medium text-green-800">Teacher Dashboard</span>
              </a>
              <a href="/dashboard/admin" class="bg-purple-50 border border-purple-200 rounded-lg p-4 flex flex-col items-center justify-center hover:bg-purple-100 transition-colors">
                <svg class="h-8 w-8 text-purple-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                </svg>
                <span class="mt-2 text-sm font-medium text-purple-800">Admin Dashboard</span>
              </a>
              <a href="/dashboard/credits" class="bg-yellow-50 border border-yellow-200 rounded-lg p-4 flex flex-col items-center justify-center hover:bg-yellow-100 transition-colors">
                <svg class="h-8 w-8 text-yellow-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                </svg>
                <span class="mt-2 text-sm font-medium text-yellow-800">Credits System</span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>
