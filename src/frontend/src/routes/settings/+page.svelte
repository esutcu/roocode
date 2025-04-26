<script lang="ts">
  import { page } from '$app/stores';
  import { onMount } from 'svelte';
  import { goto } from '$app/navigation';
  import { browser } from '$app/environment';
  
  let userRole = 'student'; // Default role
  let userSettings: {
    notifications: boolean;
    language: string;
    timezone: string;
    profileVisibility: string;
  } = {
    notifications: true,
    language: 'en',
    timezone: 'America/Toronto',
    profileVisibility: 'public'
  };
  
  if (browser) {
    onMount(async () => {
      // Get user role from localStorage
      const storedRole = localStorage.getItem('userRole');
      if (storedRole) {
        userRole = storedRole;
      }
      
      // Fetch user settings
      const settingsResponse = await fetch('/api/user/settings');
      if (settingsResponse.ok) {
        userSettings = await settingsResponse.json();
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
            <a href="#" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Home</a>
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
          <h1 class="text-lg leading-6 font-medium text-gray-900">Settings</h1>
          <p class="mt-1 max-w-2xl text-sm text-gray-500">Manage your account settings</p>
        </div>
        <div class="border-t border-gray-200">
          <div class="px-4 py-5 sm:p-6">
            <div class="space-y-6">
              <!-- Account Settings -->
              <div>
                <h3 class="text-lg leading-6 font-medium text-gray-900">Account Settings</h3>
                <div class="mt-4 grid grid-cols-1 gap-y-6 gap-x-4 sm:grid-cols-6">
                  <div class="sm:col-span-3">
                    <label for="username" class="block text-sm font-medium text-gray-700">Username</label>
                    <div class="mt-1">
                      <input type="text" id="username" name="username" class="shadow-sm focus:ring-blue-500 focus:border-blue-500 block w-full sm:text-sm border-gray-300 rounded-md p-2 border" value="user123">
                    </div>
                  </div>
                  
                  <div class="sm:col-span-3">
                    <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
                    <div class="mt-1">
                      <input type="email" id="email" name="email" class="shadow-sm focus:ring-blue-500 focus:border-blue-500 block w-full sm:text-sm border-gray-300 rounded-md p-2 border" value="user@example.com">
                    </div>
                  </div>
                  
                  <div class="sm:col-span-3">
                    <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                    <div class="mt-1">
                      <input type="password" id="password" name="password" class="shadow-sm focus:ring-blue-500 focus:border-blue-500 block w-full sm:text-sm border-gray-300 rounded-md p-2 border" placeholder="••••••••">
                    </div>
                  </div>
                  
                  <div class="sm:col-span-3">
                    <label for="confirm-password" class="block text-sm font-medium text-gray-700">Confirm Password</label>
                    <div class="mt-1">
                      <input type="password" id="confirm-password" name="confirm-password" class="shadow-sm focus:ring-blue-500 focus:border-blue-500 block w-full sm:text-sm border-gray-300 rounded-md p-2 border" placeholder="••••••••">
                    </div>
                  </div>
                </div>
              </div>
              
              <!-- Notification Settings -->
              <div>
                <h3 class="text-lg leading-6 font-medium text-gray-900">Notification Settings</h3>
                <div class="mt-4 space-y-4">
                  <div class="flex items-start">
                    <div class="flex items-center h-5">
                      <input id="email-notifications" name="email-notifications" type="checkbox" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded" checked>
                    </div>
                    <div class="ml-3 text-sm">
                      <label for="email-notifications" class="font-medium text-gray-700">Email Notifications</label>
                      <p class="text-gray-500">Receive email notifications for new bookings and messages.</p>
                    </div>
                  </div>
                  
                  <div class="flex items-start">
                    <div class="flex items-center h-5">
                      <input id="sms-notifications" name="sms-notifications" type="checkbox" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                    </div>
                    <div class="ml-3 text-sm">
                      <label for="sms-notifications" class="font-medium text-gray-700">SMS Notifications</label>
                      <p class="text-gray-500">Receive text message notifications for urgent matters.</p>
                    </div>
                  </div>
                </div>
              </div>
              
              <!-- Privacy Settings -->
              <div>
                <h3 class="text-lg leading-6 font-medium text-gray-900">Privacy Settings</h3>
                <div class="mt-4 space-y-4">
                  <div>
                    <label for="profile-visibility" class="block text-sm font-medium text-gray-700">Profile Visibility</label>
                    <select id="profile-visibility" name="profile-visibility" class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm rounded-md">
                      <option value="public" selected>Public</option>
                      <option value="private">Private</option>
                      <option value="friends">Friends Only</option>
                    </select>
                  </div>
                  
                  <div class="flex items-start">
                    <div class="flex items-center h-5">
                      <input id="data-sharing" name="data-sharing" type="checkbox" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded" checked>
                    </div>
                    <div class="ml-3 text-sm">
                      <label for="data-sharing" class="font-medium text-gray-700">Data Sharing</label>
                      <p class="text-gray-500">Allow us to share your anonymized data to improve our services.</p>
                    </div>
                  </div>
                </div>
              </div>
              
              <!-- Save Button -->
              <div class="pt-5">
                <div class="flex justify-end">
                  <button type="button" class="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 mr-3">
                    Cancel
                  </button>
                  <button type="button" class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                    Save Changes
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>