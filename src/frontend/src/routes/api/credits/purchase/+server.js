import { json } from '@sveltejs/kit';

export async function POST({ request }) {
  try {
    const { userId, packageId } = await request.json();
    
    // In a real application, you would process the payment and add credits to the user's account
    // Here we will simply return a mock response
    
    let creditsAdded;
    let packageName;
    
    // Determine credits based on package
    switch (packageId) {
      case '1':
        creditsAdded = 10;
        packageName = 'Basic Package';
        break;
      case '2':
        creditsAdded = 20;
        packageName = 'Standard Package';
        break;
      case '3':
        creditsAdded = 50;
        packageName = 'Premium Package';
        break;
      default:
        creditsAdded = 10;
        packageName = 'Basic Package';
    }
    
    const purchaseData = {
      userId,
      packageId,
      packageName,
      creditsAdded,
      totalCredits: creditsAdded, // In a real app, this would be current credits + added credits
      transactionId: 'txn-' + Math.floor(Math.random() * 10000)
    };
    
    return json(purchaseData, { status: 200 });
  } catch (error) {
    console.error('Credit purchase error:', error);
    return json({ message: 'Failed to purchase credits. Please try again.' }, { status: 400 });
  }
}