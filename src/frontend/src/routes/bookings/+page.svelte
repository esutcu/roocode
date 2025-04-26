<script lang="ts">
  import { page } from '$app/stores';
  import { onMount } from 'svelte';
  import { goto } from '$app/navigation';
  import { browser } from '$app/environment';
  
  let userRole = 'student'; // Default role
  let bookings: Array<{
    id: string;
    date: string;
    time: string;
    student?: string;
    teacher?: string;
    status: string;
  }> = [];
  
  if (browser) {
    onMount(async () => {
      // Get user role from localStorage
      const storedRole = localStorage.getItem('userRole');
      if (storedRole) {
        userRole = storedRole;
      }
      
      // Fetch user bookings
      const bookingsResponse = await fetch('/api/user/bookings');
      if (bookingsResponse.ok) {
        bookings = await bookingsResponse.json();
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
          <h1 class="text-lg leading-6 font-medium text-gray-900">Bookings</h1>
          <p class="mt-1 max-w-2xl text-sm text-gray-500">Manage your speaking sessions</p>
        </div>
        <div class="border-t border-gray-200">
          <div class="px-4 py-5 sm:p-6">
            <div class="flex justify-between mb-4">
              <h2 class="text-lg font-medium text-gray-900">Your Sessions</h2>
              {#if userRole === 'student' || userRole === 'teacher'}
                <a href="/bookings/new" class="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                  Create New Session
                </a>
              {/if}
            </div>
            
            <div class="overflow-hidden shadow ring-1 ring-black ring-opacity-5 rounded-lg sm:rounded-xl">
              <table class="min-w-full divide-y divide-gray-300">
                <thead class="bg-gray-50">
                  <tr>
                    <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">Date</th>
                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Time</th>
                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Student</th>
                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Teacher</th>
                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Status</th>
                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Actions</th>
                  </tr>
                </thead>
                <tbody class="divide-y divide-gray-200 bg-white">
                  {#each bookings as booking}
                  <tr>
                    <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6">{booking.date}</td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{booking.time}</td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      {#if booking.student}
                        {booking.student}
                      {/if}
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      {#if booking.teacher}
                        {booking.teacher}
                      {/if}
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      <span class="inline-flex items-center rounded-full bg-green-100 px-2.5 py-0.5 text-xs font-medium text-green-800">
                        {booking.status}
                      </span>
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      <button class="text-blue-600 hover:text-blue-900 mr-2">Edit</button>
                      <button class="text-red-600 hover:text-red-900">Cancel</button>
                    </td>
                  </tr>
                  {/each}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>