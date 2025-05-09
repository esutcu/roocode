<script lang="ts">
  import { page } from '$app/stores';
  import { onMount } from 'svelte';
  import { goto } from '$app/navigation';
  import { browser } from '$app/environment';
  
  let userRole = 'admin'; // Default role
  let credits = 0;
  let bookings: Array<{
    id: string;
    date: string;
    time: string;
    student: string;
    teacher: string;
    status: string;
  }> = [];
  
  if (browser) {
    onMount(async () => {
      // Get user role from localStorage
      const storedRole = localStorage.getItem('userRole');
      if (storedRole) {
        userRole = storedRole;
      }
      
      // Fetch user credits
      const creditsResponse = await fetch('/api/user/credits');
      if (creditsResponse.ok) {
        const creditsData = await creditsResponse.json();
        credits = creditsData.credits;
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
          <h1 class="text-lg leading-6 font-medium text-gray-900">Admin Dashboard</h1>
          <p class="mt-1 max-w-2xl text-sm text-gray-500">Manage the entire platform</p>
        </div>
        <div class="border-t border-gray-200">
          <div class="px-4 py-5 sm:p-6">
            <div class="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-3">
              <div class="bg-red-50 overflow-hidden shadow rounded-lg">
                <div class="px-4 py-5 sm:p-6">
                  <div class="flex items-center">
                    <div class="flex-shrink-0 bg-red-100 rounded-md p-3">
                      <svg class="h-6 w-6 text-red-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                      </svg>
                    </div>
                    <div class="ml-5 w-0">
                      <dl>
                        <dt class="text-sm font-medium text-gray-500 truncate">Total Users</dt>
                        <dd class="text-3xl font-semibold text-gray-900">247</dd>
                      </dl>
                    </div>
                  </div>
                </div>
                <div class="bg-red-50 px-4 py-4 sm:px-6">
                  <div class="flex items-center justify-between">
                    <div class="text-sm font-medium text-red-600">
                      <a href="/admin/users">View Users</a>
                    </div>
                    <div class="text-sm font-medium text-red-600">
                      <a href="/admin/users/new">Add User</a>
                    </div>
                  </div>
                </div>
              </div>
              
              <div class="bg-yellow-50 overflow-hidden shadow rounded-lg">
                <div class="px-4 py-5 sm:p-6">
                  <div class="flex items-center">
                    <div class="flex-shrink-0 bg-yellow-100 rounded-md p-3">
                      <svg class="h-6 w-6 text-yellow-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                      </svg>
                    </div>
                    <div class="ml-5 w-0">
                      <dl>
                        <dt class="text-sm font-medium text-gray-500 truncate">Total Sessions</dt>
                        <dd class="text-3xl font-semibold text-gray-900">1,247</dd>
                      </dl>
                    </div>
                  </div>
                </div>
                <div class="bg-yellow-50 px-4 py-4 sm:px-6">
                  <div class="flex items-center justify-between">
                    <div class="text-sm font-medium text-yellow-600">
                      <a href="/admin/sessions">View Sessions</a>
                    </div>
                    <div class="text-sm font-medium text-yellow-600">
                      <a href="/admin/reports">View Reports</a>
                    </div>
                  </div>
                </div>
              </div>
              
              <div class="bg-indigo-50 overflow-hidden shadow rounded-lg">
                <div class="px-4 py-5 sm:p-6">
                  <div class="flex items-center">
                    <div class="flex-shrink-0 bg-indigo-100 rounded-md p-3">
                      <svg class="h-6 w-6 text-indigo-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                      </svg>
                    </div>
                    <div class="ml-5 w-0">
                      <dl>
                        <dt class="text-sm font-medium text-gray-500 truncate">System Status</dt>
                        <dd class="text-3xl font-semibold text-gray-900">Healthy</dd>
                      </dl>
                    </div>
                  </div>
                </div>
                <div class="bg-indigo-50 px-4 py-4 sm:px-6">
                  <div class="flex items-center justify-between">
                    <div class="text-sm font-medium text-indigo-600">
                      <a href="/admin/system">System Details</a>
                    </div>
                    <div class="text-sm font-medium text-indigo-600">
                      <a href="/admin/system/maintenance">Maintenance</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="mt-8">
              <h2 class="text-lg font-medium text-gray-900">Recent Bookings</h2>
              <div class="mt-4 overflow-hidden shadow ring-1 ring-black ring-opacity-5 rounded-lg sm:rounded-xl">
                <table class="min-w-full divide-y divide-gray-300">
                  <thead class="bg-gray-50">
                    <tr>
                      <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">Date</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Time</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Student</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Teacher</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Status</th>
                    </tr>
                  </thead>
                  <tbody class="divide-y divide-gray-200 bg-white">
                    {#each bookings as booking}
                    <tr>
                      <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6">{booking.date}</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{booking.time}</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{booking.student}</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{booking.teacher}</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                        <span class="inline-flex items-center rounded-full bg-green-100 px-2.5 py-0.5 text-xs font-medium text-green-800">
                          {booking.status}
                        </span>
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
    </div>
  </main>
</div>